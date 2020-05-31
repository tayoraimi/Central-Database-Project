//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.31 at 11:54:24 AM WAT 
//


package ihvn.data.extractor.model.xml;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MessageHeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageHeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageStatusCode">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="EXPORTED"/>
 *               &lt;enumeration value="UPLOADED"/>
 *               &lt;enumeration value="VALIDATING"/>
 *               &lt;enumeration value="VALIDATED"/>
 *               &lt;enumeration value="LOADING"/>
 *               &lt;enumeration value="LOADED"/>
 *               &lt;enumeration value="PENDING"/>
 *               &lt;enumeration value="REJECTED"/>
 *               &lt;enumeration value="ERROR"/>
 *               &lt;enumeration value="PAUSED"/>
 *               &lt;enumeration value="PROCESSING"/>
 *               &lt;enumeration value="PROCESSED"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MessageSource">
 *           &lt;simpleType>
 *             &lt;restriction base="{}CodeType">
 *               &lt;enumeration value="NMRS"/>
 *               &lt;enumeration value="NOMIS"/>
 *               &lt;enumeration value="LIMS"/>
 *               &lt;enumeration value="HTSAPP"/>
 *               &lt;enumeration value="DHIS2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MessageCreationDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MessageSchemaVersion">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="99999"/>
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MessageUniqueID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityDatimCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FacilityName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UploadDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ProcessedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeaderType", propOrder = {
    "messageStatusCode",
    "messageSource",
    "messageCreationDateTime",
    "messageSchemaVersion",
    "messageUniqueID",
    "facilityDatimCode",
    "facilityName",
    "fileName",
    "uploadDate",
    "processedDate"
})
public class MessageHeaderType {

    @XmlElement(name = "MessageStatusCode", required = true)
    protected String messageStatusCode;
    @XmlElement(name = "MessageSource", required = true)
    protected String messageSource;
    @XmlElement(name = "MessageCreationDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar messageCreationDateTime;
    @XmlElement(name = "MessageSchemaVersion", required = true)
    protected BigDecimal messageSchemaVersion;
    @XmlElement(name = "MessageUniqueID", required = true)
    protected String messageUniqueID;
    @XmlElement(name = "FacilityDatimCode", required = true)
    protected String facilityDatimCode;
    @XmlElement(name = "FacilityName", required = true)
    protected String facilityName;
    @XmlElement(name = "FileName", required = true)
    protected String fileName;
    @XmlElement(name = "UploadDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar uploadDate;
    @XmlElement(name = "ProcessedDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar processedDate;

    /**
     * Gets the value of the messageStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageStatusCode() {
        return messageStatusCode;
    }

    /**
     * Sets the value of the messageStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageStatusCode(String value) {
        this.messageStatusCode = value;
    }

    /**
     * Gets the value of the messageSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageSource() {
        return messageSource;
    }

    /**
     * Sets the value of the messageSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageSource(String value) {
        this.messageSource = value;
    }

    /**
     * Gets the value of the messageCreationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMessageCreationDateTime() {
        return messageCreationDateTime;
    }

    /**
     * Sets the value of the messageCreationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMessageCreationDateTime(XMLGregorianCalendar value) {
        this.messageCreationDateTime = value;
    }

    /**
     * Gets the value of the messageSchemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMessageSchemaVersion() {
        return messageSchemaVersion;
    }

    /**
     * Sets the value of the messageSchemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMessageSchemaVersion(BigDecimal value) {
        this.messageSchemaVersion = value;
    }

    /**
     * Gets the value of the messageUniqueID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageUniqueID() {
        return messageUniqueID;
    }

    /**
     * Sets the value of the messageUniqueID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageUniqueID(String value) {
        this.messageUniqueID = value;
    }

    /**
     * Gets the value of the facilityDatimCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityDatimCode() {
        return facilityDatimCode;
    }

    /**
     * Sets the value of the facilityDatimCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityDatimCode(String value) {
        this.facilityDatimCode = value;
    }

    /**
     * Gets the value of the facilityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityName() {
        return facilityName;
    }

    /**
     * Sets the value of the facilityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityName(String value) {
        this.facilityName = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the uploadDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the value of the uploadDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUploadDate(XMLGregorianCalendar value) {
        this.uploadDate = value;
    }

    /**
     * Gets the value of the processedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProcessedDate() {
        return processedDate;
    }

    /**
     * Sets the value of the processedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProcessedDate(XMLGregorianCalendar value) {
        this.processedDate = value;
    }

}
