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

@Entity(name = "ModelFile")
@Table(name = "\"ModelFile\"", schema =  "\"generated_app\"")
@Data
                        
public class ModelFile {
	public ModelFile () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ModelId\"", nullable = true )
  private Long modelId;
	  
  @Column(name = "\"ModelName\"", nullable = true )
  private String modelName;
  
	  
  @Column(name = "\"ModelDescription\"", nullable = true )
  private String modelDescription;
  
	  
  @Column(name = "\"Path\"", nullable = true )
  private String path;
  
	  
  @Column(name = "\"ModelType\"", nullable = false)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = ModelTypeConverter.class)
  private ModelType modelType;
  
	  
  @Column(name = "\"CreatedBy\"", nullable = false)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = ModelCreatorConverter.class)
  private ModelCreator createdBy;
  
	  
  @Column(name = "\"IconPath\"", nullable = true )
  private String iconPath;
  
	  
  @Column(name = "\"UserName\"", nullable = true )
  private String userName;
  
	  
  @Column(name = "\"ModelFileName\"", nullable = true )
  private String modelFileName;
  
	  
  @Column(name = "\"ModelFileVersion\"", nullable = true )
  private String modelFileVersion;
  
  
  
  
		@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"ModelFileIndustry\"", referencedColumnName = "\"IndustryId\"", insertable = false, updatable = false)
	private Industry industry;
	
	@Column(name = "\"ModelFileIndustry\"")
	private Long modelFileIndustry;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "\"ModelFileFile\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document file;
	
	@Column(name = "\"ModelFileFile\"")
	private Long modelFileFile;
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "ModelFile [" 
  + "ModelId= " + modelId  + ", " 
  + "ModelName= " + modelName  + ", " 
  + "ModelDescription= " + modelDescription  + ", " 
  + "Path= " + path  + ", " 
  + "ModelType= " + modelType  + ", " 
  + "CreatedBy= " + createdBy  + ", " 
  + "IconPath= " + iconPath  + ", " 
  + "UserName= " + userName  + ", " 
  + "ModelFileName= " + modelFileName  + ", " 
  + "ModelFileVersion= " + modelFileVersion 
 + "]";
	}
	
}