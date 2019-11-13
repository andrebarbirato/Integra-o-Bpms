package br.com.unimedfortaleza.bpmsintegration.soap;

public class JiraApiSoapProxy implements br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap {
  private String _endpoint = null;
  private br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap jiraApiSoap = null;
  
  public JiraApiSoapProxy() {
    _initJiraApiSoapProxy();
  }
  
  public JiraApiSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initJiraApiSoapProxy();
  }
  
  private void _initJiraApiSoapProxy() {
    try {
      jiraApiSoap = (new br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoapServiceLocator()).getJiraApiSoap();
      if (jiraApiSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)jiraApiSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)jiraApiSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (jiraApiSoap != null)
      ((javax.xml.rpc.Stub)jiraApiSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.unimedfortaleza.bpmsintegration.soap.JiraApiSoap getJiraApiSoap() {
    if (jiraApiSoap == null)
      _initJiraApiSoapProxy();
    return jiraApiSoap;
  }
  
  public java.lang.String findUsers(java.lang.String criterio) throws java.rmi.RemoteException{
    if (jiraApiSoap == null)
      _initJiraApiSoapProxy();
    return jiraApiSoap.findUsers(criterio);
  }
  
  
}