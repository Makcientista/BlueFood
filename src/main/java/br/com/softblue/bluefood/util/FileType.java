package br.com.softblue.bluefood.util;

public enum FileType {

	PNG ("image/png", "png"),
	JPG ("image/jpeg", "jpg");
	
	String mineType;
	String extension;
	
	FileType(String mineType, String extension){
		this.mineType = mineType;
		this.extension = extension;
	}
	
	public String getExtension() {
		return extension;
	}
	
	public String getMineType() {
		return mineType;
	}
	
	private boolean sameOf(String mineType) {
		return this.mineType.equalsIgnoreCase(mineType);
	}
	
	public static FileType of(String mineType) {
		for(FileType fileType : values()) {
			if (fileType.sameOf(mineType)) {
				return fileType;
			}
		}
		return null;
	}
}
