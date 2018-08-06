package me.coco0325.SlimeLab;

public class ServerLocation {
	private String server, world;
	private Integer x, y, z;
	
	public ServerLocation(String server, String world, Integer x, Integer y, Integer z) {
		this.server = server;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String getServer() {
        return server;
    }

    public String getWorld() {
        return world;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }
}
