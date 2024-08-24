
package net.clozynoii.drstone.client.renderer;

import net.clozynoii.drstone.entity.model.StoneHumanPlayer2Model;
import net.clozynoii.drstone.entity.StoneHumanPlayer2Entity;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.HttpTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.loading.FMLPaths;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.model.GeoModel;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import java.util.Optional;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

public class StoneHumanPlayer2Renderer extends GeoEntityRenderer<StoneHumanPlayer2Entity> {
 private static final MinecraftSessionService sessionService = Minecraft.getInstance().getMinecraftSessionService();
    private final TextureManager textureManager = Minecraft.getInstance().getTextureManager();
    private final GeoModel<StoneHumanPlayer2Entity> slimModel;
    private final GeoModel<StoneHumanPlayer2Entity> defaultModel;
    private GeoModel<StoneHumanPlayer2Entity> currentModel;

    public StoneHumanPlayer2Renderer(EntityRendererProvider.Context context) {
        super(context, new StoneHumanPlayer2Model());
        this.slimModel = new StoneHumanPlayer2Model();
        this.defaultModel = new StoneHumanPlayer2Model();
        this.currentModel = this.defaultModel;
    }

    @Override
    public ResourceLocation getTextureLocation(StoneHumanPlayer2Entity entity) {
        if (entity.isTame() && entity.getOwnerUUID() != null) {
            UUID ownerUUID = entity.getOwnerUUID();
            return getGrayscalePlayerSkin(ownerUUID);
        } else {
            return new ResourceLocation("drstone:textures/entities/blank.png");
        }
    }

    @Override
    public void render(StoneHumanPlayer2Entity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.isTame() && entity.getOwnerUUID() != null) {
            UUID ownerUUID = entity.getOwnerUUID();
            this.currentModel = getModel(ownerUUID);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    private GeoModel<StoneHumanPlayer2Entity> getModel(UUID uuid) {
        boolean isSlim = isSlimSkin(uuid);
        System.out.println("UUID: " + uuid + " isSlim: " + isSlim); // Debug log
        return isSlim ? slimModel : defaultModel;
    }

        private ResourceLocation getGrayscalePlayerSkin(UUID uuid) {
        GameProfile profile = new GameProfile(uuid, null);
        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> textures = sessionService.getTextures(sessionService.fillProfileProperties(profile, false), false);

        if (textures.containsKey(MinecraftProfileTexture.Type.SKIN)) {
            MinecraftProfileTexture profileTexture = textures.get(MinecraftProfileTexture.Type.SKIN);
            String skinUrl = profileTexture.getUrl();
            String skinHash = profileTexture.getHash();
            File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
            File originalSkinFile = new File(skinDir, skinHash + ".png");
            File grayscaleSkinFile = new File(skinDir, skinHash + "_grayscale.png");

            if (!skinDir.exists()) {
                skinDir.mkdirs();
            }

            // Download the original skin if not already downloaded
            if (!originalSkinFile.exists()) {
                try {
                    downloadSkin(skinUrl, originalSkinFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    return DefaultPlayerSkin.getDefaultSkin(uuid);
                }
            }

            // Convert to grayscale if not already converted
            if (!grayscaleSkinFile.exists()) {
                try {
                    convertToGrayscale(originalSkinFile, grayscaleSkinFile);
                } catch (IOException e) {
                    e.printStackTrace();
                    return DefaultPlayerSkin.getDefaultSkin(uuid);
                }
            }

            // Register and return the grayscale texture
            ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash + "_grayscale");
            HttpTexture httpTexture = new HttpTexture(grayscaleSkinFile, skinUrl, DefaultPlayerSkin.getDefaultSkin(uuid), false, null);
            textureManager.register(resourceLocation, httpTexture);

            return resourceLocation;
        } else {
            return DefaultPlayerSkin.getDefaultSkin(uuid);
        }
    }

    private void downloadSkin(String skinUrl, File skinFile) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(skinUrl).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try (InputStream inputStream = connection.getInputStream()) {
            Files.copy(inputStream, skinFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } finally {
            connection.disconnect();
        }
    }

private void convertToGrayscale(File inputFile, File outputFile) throws IOException {
    BufferedImage originalImage = ImageIO.read(inputFile);

    // Create a new BufferedImage with the same dimensions but in grayscale
    BufferedImage grayscaleImage = new BufferedImage(
            originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

    // Loop through each pixel and convert it to grayscale
    for (int y = 0; y < originalImage.getHeight(); y++) {
        for (int x = 0; x < originalImage.getWidth(); x++) {
            int rgb = originalImage.getRGB(x, y);
            int alpha = (rgb >> 24) & 0xff;
            int red = (rgb >> 16) & 0xff;
            int green = (rgb >> 8) & 0xff;
            int blue = rgb & 0xff;

            // Calculate the luminance (grayscale value) using a standard formula
            int luminance = (int) (0.3 * red + 0.59 * green + 0.11 * blue);

            // Recreate the grayscale color
            int grayscale = (alpha << 24) | (luminance << 16) | (luminance << 8) | luminance;

            grayscaleImage.setRGB(x, y, grayscale);
        }
    }

    // Load the overlay image
    ResourceLocation overlayLocation = new ResourceLocation("drstone:textures/entities/stone_overlay.png");
    ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
    Optional<Resource> optionalResource = resourceManager.getResource(overlayLocation);

    if (optionalResource.isPresent()) {
        try (InputStream overlayStream = optionalResource.get().open()) {
            BufferedImage overlayImage = ImageIO.read(overlayStream);

            // Apply the overlay onto the grayscale image
            for (int y = 0; y < grayscaleImage.getHeight(); y++) {
                for (int x = 0; x < grayscaleImage.getWidth(); x++) {
                    int grayscaleRGB = grayscaleImage.getRGB(x, y);
                    int overlayRGB = overlayImage.getRGB(x, y);

                    // Combine the overlay and grayscale image based on overlay alpha
                    int overlayAlpha = (overlayRGB >> 24) & 0xff;
                    if (overlayAlpha > 0) {
                        // Simple alpha blending
                        int blendedRGB = blendColors(grayscaleRGB, overlayRGB);
                        grayscaleImage.setRGB(x, y, blendedRGB);
                    }
                }
            }
        }
    } else {
        throw new IOException("Overlay resource not found: " + overlayLocation);
    }

    // Save the resulting image
    ImageIO.write(grayscaleImage, "png", outputFile);
}

private int blendColors(int baseRGB, int overlayRGB) {
    int baseAlpha = (baseRGB >> 24) & 0xff;
    int baseRed = (baseRGB >> 16) & 0xff;
    int baseGreen = (baseRGB >> 8) & 0xff;
    int baseBlue = baseRGB & 0xff;

    int overlayAlpha = (overlayRGB >> 24) & 0xff;
    int overlayRed = (overlayRGB >> 16) & 0xff;
    int overlayGreen = (overlayRGB >> 8) & 0xff;
    int overlayBlue = overlayRGB & 0xff;

    // Blend the colors using overlay alpha
    int alpha = Math.min(255, baseAlpha + overlayAlpha);
    int red = (baseRed * (255 - overlayAlpha) + overlayRed * overlayAlpha) / 255;
    int green = (baseGreen * (255 - overlayAlpha) + overlayGreen * overlayAlpha) / 255;
    int blue = (baseBlue * (255 - overlayAlpha) + overlayBlue * overlayAlpha) / 255;

    return (alpha << 24) | (red << 16) | (green << 8) | blue;
}


    private boolean isSlimSkin(UUID uuid) {
        GameProfile profile = new GameProfile(uuid, null);
        profile = sessionService.fillProfileProperties(profile, false);
        if (profile.getProperties().containsKey("textures")) {
            for (Property property : profile.getProperties().get("textures")) {
                String value = new String(java.util.Base64.getDecoder().decode(property.getValue()));
                if (value.contains("\"slim\"")) {
                    return true;
                }
            }
        }
        return false;
    }
}