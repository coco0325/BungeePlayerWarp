package me.coco0325.SlimeLab.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.entity.Player;

import me.coco0325.SlimeLab.ServerLocation;

public class TPutils {
	
	public void TPplayerToServerLocation(Player p, ServerLocation loc) {
		
		String sY = "" + loc.getY();
        if (loc.getY() == Double.MAX_VALUE)
            sY = "HIGHEST";
		ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Teleport");
            out.writeUTF(p.getName());
            out.writeUTF("LOCATION");
            out.writeUTF(loc.getWorld());
            out.writeUTF("" + loc.getX());
            out.writeUTF(sY);
            out.writeUTF("" + loc.getZ());
            out.writeUTF("" + loc.getPitch());
            out.writeUTF("" + loc.getYaw());
        } catch (IOException e) {
            e.printStackTrace();
        }
        loc.getServer().sendData("ProxySuite", b.toByteArray());

        if (p.getServer().getInfo() != loc.getServer())
            p.connect(loc.getServer());
	}
}
