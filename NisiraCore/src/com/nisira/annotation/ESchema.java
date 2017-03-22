package com.nisira.annotation;

public class ESchema {
	private String schema;
	private boolean esSch;
	public ESchema(Schema schema) {
		this.setEsSch((schema!=null));
		if(this.isEsSch()){
			this.schema=schema.schema().trim();
		}
	}
	public void setPKMetaData(Schema schema) {
		this.setEsSch((schema!=null));
		if(this.isEsSch()){
			this.schema=schema.schema().trim();
		}
	}
	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	private boolean isEsSch() {
		return esSch;
	}
	private void setEsSch(boolean esSch) {
		this.esSch = esSch;
	}
}
