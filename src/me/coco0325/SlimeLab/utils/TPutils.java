package me.coco0325.SlimeLab.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.entity.Player;

import me.coco0325.SlimeLab.PlayerWarp;
import me.coco0325.SlimeLab.ServerLocation;

public class TPutils {
	
	private PlayerWarp plugin = PlayerWarp.plugin;
	
	public void TPplayerToServerLocation(Player p, ServerLocation loc) {
		
		String sY = "" + loc.getY();
        if (loc.getY() == Double.MAX_VALUE)
            sY = "HIGHEST";
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
	        out.writeUTF("Forward"); 
	        out.writeUTF("ALL");
	        out.writeUTF("Teleport");
	        out.writeUTF(p.getName());
	        out.writeUTF("LOCATION");
	        out.writeUTF(loc.getWorld());
	        out.writeUTF("" + loc.getX());
	        out.writeUTF(sY);
	        out.writeUTF("" + loc.getZ());
	        out.writeUTF("" + loc.getPitch());
	        out.writeUTF("" + loc.getYaw());
	        
	        out.writeShort(b.toByteArray().length);
	        out.write(b.toByteArray());
        } catch(IOException e) {
        	e.printStackTrace();
        }

        p.sendPluginMessage(plugin, "ProxySuite", b.toByteArray());
	}
}
