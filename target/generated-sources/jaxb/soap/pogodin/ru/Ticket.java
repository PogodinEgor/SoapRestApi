//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.02 at 03:47:12 PM MSK 
//


package soap.pogodin.ru;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ticket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ticket"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="doctor" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="patient" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="startTime" type="{http://www.w3.org/2001/XMLSchema}time"/&gt;
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}time"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = {
    "id",
    "doctor",
    "patient",
    "date",
    "startTime",
    "endTime"
})
public class Ticket {

    protected long id;
    protected long doctor;
    protected long patient;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar startTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar endTime;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the doctor property.
     * 
     */
    public long getDoctor() {
        return doctor;
    }

    /**
     * Sets the value of the doctor property.
     * 
     */
    public void setDoctor(long value) {
        this.doctor = value;
    }

    /**
     * Gets the value of the patient property.
     * 
     */
    public long getPatient() {
        return patient;
    }

    /**
     * Sets the value of the patient property.
     * 
     */
    public void setPatient(long value) {
        this.patient = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the startTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartTime(XMLGregorianCalendar value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndTime(XMLGregorianCalendar value) {
        this.endTime = value;
    }

}
