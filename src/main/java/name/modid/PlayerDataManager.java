package name.modid;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;

public class PlayerDataManager {
    private static Map<UUID, Integer> playerData = new HashMap<>();

    public static void loadPlayerData() {
        try {
            File file = new File("playerData.json");
            if (file.exists()) {
                String content = new String(Files.readAllBytes(file.toPath()));
                JSONObject json = new JSONObject(content);
                for (String key : json.keySet()) {
                    playerData.put(UUID.fromString(key), json.getInt(key));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePlayerData() {
        try {
            JSONObject json = new JSONObject();
            for (UUID key : playerData.keySet()) {
                json.put(key.toString(), playerData.get(key));
            }
            Files.write(Paths.get("playerData.json"), json.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<UUID, Integer> getPlayerData() {
        return playerData;
    }
}
