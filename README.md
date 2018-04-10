# AutomateBYSeleniumJava
Automate the page by selenium and Java  sample project 


Created a Schema for all files with  sqx/src/** 

How can We create a xsd file :
-----------------------------
- Login to your org 
- Go to setup->Api->Metadata WSDL ->Generate Metadata WSDL  (Download the file)
- Open the metadata.xml file and find out the element which is needed to be generated as schema 

Example :
-------------
To Create a xsd file for ApexPage as Example 

- Go to the metadata.xml file which have been downloaded 
- create a xsd file for  ApexPage with schema xs:schema having an element of ApexPage
Eg: 
```<?xml version="1.0" encoding="UTF-8"?>
<xs:schema elementFormDefault="qualified" targetNamespace="http://soap.sforce.com/2006/04/metadata" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://soap.sforce.com/2006/04/metadata">
    <xs:element name="ApexPage">
    </xs:element>
</xs:schema>
```
- search for ApexPage name with in complexType  in metadata.xml
- you will find Like this in metadata.xml  
Eg:
  ``` <xsd:complexType name="ApexPage">
    <xsd:complexContent>
     <xsd:extension base="tns:MetadataWithContent">
      <xsd:sequence>
       <xsd:element name="apiVersion" type="xsd:double"/>
       <xsd:element name="availableInTouch" minOccurs="0" type="xsd:boolean"/>
       <xsd:element name="confirmationTokenRequired" minOccurs="0" type="xsd:boolean"/>
       <xsd:element name="description" minOccurs="1" type="xsd:string"/>
       <xsd:element name="label" type="xsd:string"/>
       <xsd:element name="packageVersions" minOccurs="0" maxOccurs="unbounded" type="tns:PackageVersion"/>
      </xsd:sequence>
     </xsd:extension>
    </xsd:complexContent>
   </xsd:complexType>```

- copy ApexPage complexType and paste with inside element name ApexPage
```
  <xs:element name="ApexPage">
        Paste the complexType  which you have copy 
     </xs:element>
```
- Remove the name ="ApexPage"  from complex Type :: ``` <xsd:complexType name="ApexPage"> ```
This is  because Attribute 'name' Cannot Appear In Element 'complexType'. 

- Find the tns:MetadataWithContent in metadata.xml  
```
  <xs:complexType name="MetadataWithContent">
        <xs:complexContent>
            <xs:extension base="tns:Metadata">
                <xs:sequence>
                    <xs:element name="content" minOccurs="0" type="xs:base64Binary" />
                </xs:sequence>
            </xs:extension>
        </xs:complexContent>
    </xs:complexType>
```
- copy the MetadataWithContent and paste it below the end tag of element within endtag of schema 

- Find the tns:someType  in metadata in paste it until its cover all tns:someType  with in element like ApexPage

Validate Xml with Xsd 
-----------------------

* antscripts/fileDescription.build.xml file ::  Ant Task SchemaValidation is used to verify xml with xsd file  

* antscripts/fileDescription.build.properties :: Define  the srcfolder destination sqx/src/**


Reference
----------- 
https://www.w3schools.com/xml/el_element.asp  -- For Attribute name can't be ComplexType 

https://www.liquid-technologies.com/online-xsd-validator - Online XML Validator (XSD)
