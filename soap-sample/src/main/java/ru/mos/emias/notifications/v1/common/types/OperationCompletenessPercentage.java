
package ru.mos.emias.notifications.v1.common.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * �������� �������� ������� ���������� �������� � ��������� (0%-100%)
 * 
 * <p>Java class for OperationCompletenessPercentage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationCompletenessPercentage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://emias.mos.ru/notifications/v1/common/types/}OperationCompletenessBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="completenessStatus"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedByte"&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxInclusive value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationCompletenessPercentage", propOrder = {
    "completenessStatus"
})
public abstract class OperationCompletenessPercentage
    extends OperationCompletenessBase
{

    protected short completenessStatus;

    /**
     * Gets the value of the completenessStatus property.
     * 
     */
    public short getCompletenessStatus() {
        return completenessStatus;
    }

    /**
     * Sets the value of the completenessStatus property.
     * 
     */
    public void setCompletenessStatus(short value) {
        this.completenessStatus = value;
    }

}
