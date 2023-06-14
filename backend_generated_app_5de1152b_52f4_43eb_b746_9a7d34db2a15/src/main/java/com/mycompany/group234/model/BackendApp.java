package com.mycompany.group234.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.mycompany.group234.model.Database;
import com.mycompany.group234.model.Document;
import com.mycompany.group234.model.Project;
import com.mycompany.group234.model.ModelFile;
import com.mycompany.group234.model.Capability;
import com.mycompany.group234.model.Industry;
import com.mycompany.group234.model.User;
import com.mycompany.group234.model.BETechnology;
import com.mycompany.group234.model.BackendApp;
import com.mycompany.group234.model.complex.BasicDetails;
import com.mycompany.group234.enums.IndustryType;
import com.mycompany.group234.enums.ModelType;
import com.mycompany.group234.enums.ModelCreator;
import com.mycompany.group234.converter.IndustryTypeConverter;
import com.mycompany.group234.converter.ModelTypeConverter;
import com.mycompany.group234.converter.ModelCreatorConverter;
import com.mycompany.group234.converter.DurationConverter;
import com.mycompany.group234.converter.UUIDToByteConverter;
import com.mycompany.group234.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "BackendApp")
@Table(name = "\"BackendApp\"", schema =  "\"generated_app\"")
@Data
                        
public class BackendApp {
	public BackendApp () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"AppId\"", nullable = true )
  private Long appId;
	  
  @Embedded
  @Column(name = "\"ProjectDetails\"")
  @AttributeOverrides({
            	@AttributeOverride(name = "appName", column = @Column(name = "\"ProjectDetails_AppName\"")) ,
            	@AttributeOverride(name = "appDescription", column = @Column(name = "\"ProjectDetails_AppDescription\"")) ,
            	@AttributeOverride(name = "namespace", column = @Column(name = "\"ProjectDetails_Namespace\"")) ,
            	@AttributeOverride(name = "packageManagement", column = @Column(name = "\"ProjectDetails_PackageManagement\"")) ,
            	@AttributeOverride(name = "buildTool", column = @Column(name = "\"ProjectDetails_BuildTool\"")) ,
            	@AttributeOverride(name = "server", column = @Column(name = "\"ProjectDetails_Server\"")) ,
            	@AttributeOverride(name = "architecture", column = @Column(name = "\"ProjectDetails_Architecture\""))  }) 
  private BasicDetails projectDetails;
  
	  
  @Column(name = "\"DbSchemaName\"", nullable = true )
  private String dbSchemaName;
  
  
  
  
		@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppModel\"", referencedColumnName = "\"ModelId\"", insertable = false, updatable = false)
	private ModelFile model;
	
	@Column(name = "\"BackendAppModel\"")
	private Long backendAppModel;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppDatabase\"", referencedColumnName = "\"DbId\"", insertable = false, updatable = false)
	private Database database;
	
	@Column(name = "\"BackendAppDatabase\"")
	private Integer backendAppDatabase;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"BackendAppTechnology\"", referencedColumnName = "\"BeTechId\"", insertable = false, updatable = false)
	private BETechnology technology;
	
	@Column(name = "\"BackendAppTechnology\"")
	private Integer backendAppTechnology;
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"BackendAppCapabilities\"",
            joinColumns = @JoinColumn( name="\"AppId\""),
            inverseJoinColumns = @JoinColumn( name="\"CapabilityId\""), schema = "\"generated_app\"")
private List<Capability> capabilities = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "BackendApp [" 
  + "AppId= " + appId  + ", " 
  + "ProjectDetails= " + projectDetails  + ", " 
  + "DbSchemaName= " + dbSchemaName 
 + "]";
	}
	
}