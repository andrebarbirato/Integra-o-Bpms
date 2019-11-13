/**
 * JiraApiSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.unimedfortaleza.bpmsintegration.soap;

public interface JiraApiSoapService extends javax.xml.rpc.Service {
    public java.lang.String getJiraApiSoapAddress();

    public br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap getJiraApiSoap() throws javax.xml.rpc.ServiceException;

    public br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap getJiraApiSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
