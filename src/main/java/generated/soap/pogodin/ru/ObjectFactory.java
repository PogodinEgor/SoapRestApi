//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.09 at 11:26:44 PM MSK 
//


package soap.pogodin.ru;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.pogodin.ru package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.pogodin.ru
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateScheduleRequest }
     * 
     */
    public CreateScheduleRequest createCreateScheduleRequest() {
        return new CreateScheduleRequest();
    }

    /**
     * Create an instance of {@link CreateScheduleResponse }
     * 
     */
    public CreateScheduleResponse createCreateScheduleResponse() {
        return new CreateScheduleResponse();
    }

    /**
     * Create an instance of {@link TicketStatus }
     * 
     */
    public TicketStatus createTicketStatus() {
        return new TicketStatus();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

}
