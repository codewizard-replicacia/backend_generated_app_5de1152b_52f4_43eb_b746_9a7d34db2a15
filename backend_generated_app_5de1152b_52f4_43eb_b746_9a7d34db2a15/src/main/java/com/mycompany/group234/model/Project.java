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

@Entity(name = "Project")
@Table(name = "\"Project\"", schema =  "\"generated_app\"")
@Data
                        
public class Project {
	public Project () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ProjectId\"", nullable = true )
  private Long projectId;
	  
  @Column(name = "\"ProjectName\"", nullable = true )
  private String projectName;
  
	  
  @Column(name = "\"Version\"", nullable = true )
  private String version;
  
	  
  @Column(name = "\"Description\"", nullable = true )
  private String description;
  
	  
  @Column(name = "\"CustomerName\"", nullable = true )
  private String customerName;
  
	  
  @Column(name = "\"StartDate\"")
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date startDate;  
  
	  
  @Column(name = "\"EndDate\"")
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date endDate;  
  
	  
  @Column(name = "\"CustomerAccountName\"", nullable = true )
  private String customerAccountName;
  
	  
  @Column(name = "\"ProjectLogo\"", nullable = true )
  private byte[] projectLogo;
  
	  
  @Column(name = "\"UserNameEmail\"", nullable = true )
  private String userNameEmail;
  
	  
  @Column(name = "\"Apptier\"", nullable = true )
  private Integer apptier;
  
	  
  @Column(name = "\"GitHubURL\"", nullable = true )
  private String gitHubURL;
  
	  
  @Column(name = "\"RepositoryName\"", nullable = true )
  private String repositoryName;
  
  
  
  
   
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"ProjectCapabilities\"",
            joinColumns = @JoinColumn( name="\"ProjectId\""),
            inverseJoinColumns = @JoinColumn( name="\"CapabilityId\""), schema = "\"generated_app\"")
private List<Capability> capabilities = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"ProjectBackendApps\"",
            joinColumns = @JoinColumn( name="\"ProjectId\""),
            inverseJoinColumns = @JoinColumn( name="\"AppId\""), schema = "\"generated_app\"")
private List<BackendApp> backendApps = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Project [" 
  + "ProjectId= " + projectId  + ", " 
  + "ProjectName= " + projectName  + ", " 
  + "Version= " + version  + ", " 
  + "Description= " + description  + ", " 
  + "CustomerName= " + customerName  + ", " 
  + "StartDate= " + startDate  + ", " 
  + "EndDate= " + endDate  + ", " 
  + "CustomerAccountName= " + customerAccountName  + ", " 
  + "ProjectLogo= " + projectLogo  + ", " 
  + "UserNameEmail= " + userNameEmail  + ", " 
  + "Apptier= " + apptier  + ", " 
  + "GitHubURL= " + gitHubURL  + ", " 
  + "RepositoryName= " + repositoryName 
 + "]";
	}
	
}