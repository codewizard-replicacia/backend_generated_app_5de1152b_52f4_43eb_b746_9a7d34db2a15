package com.mycompany.group234.model.complex;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class BasicDetails {
  
	
  @Column(name = "\"AppName\"", nullable = true)
  private String appName;
	
  @Column(name = "\"AppDescription\"", nullable = true)
  private String appDescription;
	
  @Column(name = "\"Namespace\"", nullable = true)
  private String namespace;
	
  @Column(name = "\"PackageManagement\"", nullable = true)
  private String packageManagement;
	
  @Column(name = "\"BuildTool\"", nullable = true)
  private String buildTool;
	
  @Column(name = "\"Server\"", nullable = true)
  private String server;
	
  @Column(name = "\"Architecture\"", nullable = true)
  private String architecture;
}
