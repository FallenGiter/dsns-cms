<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">

<hibernate-mapping package="org.dsns.template.entity">
    <class name="Template" table="cms_template" >
		<meta attribute="sync-DAO">false</meta>
		<cache usage="read-write"/>

        <id name="id" type="java.lang.Integer">
        	<column name="id"></column>
        	<generator class="identity" />
        </id>
        
        <property name="name" type="java.lang.String">
            <column name="name" length="24" />
        </property>
        <property name="uri" type="java.lang.String">
            <column name="uri" length="24" />
        </property>
        <property name="generatedUri" type="java.lang.String">
            <column name="generated_uri" length="24" />
        </property>
        <property name="ordseq" type="int">
            <column name="ordseq" length="4" />
        </property>
        <property name="state" type="int">
            <column name="state" length="4" />
        </property>
        
        <many-to-one name="category" column="category" class="TemplateCategory" />
        <many-to-one name="website" column="website" class="org.dsns.website.entity.Website" />
    </class>
</hibernate-mapping>
