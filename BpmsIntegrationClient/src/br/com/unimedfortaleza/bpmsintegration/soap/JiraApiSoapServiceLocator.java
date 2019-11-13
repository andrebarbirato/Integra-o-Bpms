/**
 * JiraApiSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.unimedfortaleza.bpmsintegration.soap;

public class JiraApiSoapServiceLocator extends org.apache.axis.client.Service implements br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoapService {

    public JiraApiSoapServiceLocator() {
    }


    public JiraApiSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public JiraApiSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for JiraApiSoap
    private java.lang.String JiraApiSoap_address = "http://localhost:8090/BpmsIntegration/services/JiraApiSoap";

    public java.lang.String getJiraApiSoapAddress() {
        return JiraApiSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String JiraApiSoapWSDDServiceName = "JiraApiSoap";

    public java.lang.String getJiraApiSoapWSDDServiceName() {
        return JiraApiSoapWSDDServiceName;
    }

    public void setJiraApiSoapWSDDServiceName(java.lang.String name) {
        JiraApiSoapWSDDServiceName = name;
    }

    public br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap getJiraApiSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(JiraApiSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJiraApiSoap(endpoint);
    }

    public br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap getJiraApiSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoapSoapBindingStub _stub = new br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoapSoapBindingStub(portAddress, this);
            _stub.setPortName(getJiraApiSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJiraApiSoapEndpointAddress(java.lang.String address) {
        JiraApiSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoapSoapBindingStub _stub = new br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoapSoapBindingStub(new java.net.URL(JiraApiSoap_address), this);
                _stub.setPortName(getJiraApiSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("JiraApiSoap".equals(inputPortName)) {
            return getJiraApiSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.bpmsintegration.unimedfortaleza.com.br", "JiraApiSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.bpmsintegration.unimedfortaleza.com.br", "JiraApiSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("JiraApiSoap".equals(portName)) {
            setJiraApiSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
