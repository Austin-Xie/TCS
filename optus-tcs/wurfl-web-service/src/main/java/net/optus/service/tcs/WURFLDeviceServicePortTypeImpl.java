package net.optus.service.tcs;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import net.optus.service.tcs.xsd.GetAllGroupsResponse;
import net.optus.service.tcs.xsd.GetAllOptusApplicationsResponse;
import net.optus.service.tcs.xsd.GetMakesResponse;
import net.optus.service.tcs.xsd.GetVersionResponse;
import net.optus.service.tcs.xsd.OptusApplication;
import net.optus.service.tcs.xsd.OptusCapability;
import net.optus.service.tcs.xsd.OptusDevice;


@WebService(targetNamespace = "http://tcs.service.optus.net/",
//portName="DoubleItPort",
serviceName="WURFLDeviceService",
endpointInterface="net.optus.service.tcs.WURFLDeviceServicePortType")
public class WURFLDeviceServicePortTypeImpl implements
WURFLDeviceServicePortType {

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getCapabilityForUserAgentAndCapabilityName")
	@RequestWrapper(localName = "getCapabilityForUserAgentAndCapabilityName", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetCapabilityForUserAgentAndCapabilityName")
	@ResponseWrapper(localName = "getCapabilityForUserAgentAndCapabilityNameResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetCapabilityForUserAgentAndCapabilityNameResponse")
	@WebMethod(action = "urn:getCapabilityForUserAgentAndCapabilityName")
	public String getCapabilityForUserAgentAndCapabilityName(
			@WebParam(name = "ua", targetNamespace = "http://tcs.service.optus.net/xsd") String ua,
			@WebParam(name = "capName", targetNamespace = "http://tcs.service.optus.net/xsd") String capName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getDevicesWithCapabilities")
	@RequestWrapper(localName = "getDevicesWithCapabilities", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetDevicesWithCapabilities")
	@ResponseWrapper(localName = "getDevicesWithCapabilitiesResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetDevicesWithCapabilitiesResponse")
	@WebMethod(action = "urn:getDevicesWithCapabilities")
	public List<OptusDevice> getDevicesWithCapabilities(
			@WebParam(name = "caps", targetNamespace = "http://tcs.service.optus.net/xsd") List<OptusCapability> caps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getOptusApplicationByName")
	@RequestWrapper(localName = "getOptusApplicationByName", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetOptusApplicationByName")
	@ResponseWrapper(localName = "getOptusApplicationByNameResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetOptusApplicationByNameResponse")
	@WebMethod(action = "urn:getOptusApplicationByName")
	public OptusApplication getOptusApplicationByName(
			@WebParam(name = "appName", targetNamespace = "http://tcs.service.optus.net/xsd") String appName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	@WebResult(name = "getVersionResponse", targetNamespace = "http://tcs.service.optus.net/xsd", partName = "part1")
	@Action(input = "urn:getVersion")
	@WebMethod(action = "urn:getVersion")
	public GetVersionResponse getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getCapabilityNamesForGroup")
	@RequestWrapper(localName = "getCapabilityNamesForGroup", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetCapabilityNamesForGroup")
	@ResponseWrapper(localName = "getCapabilityNamesForGroupResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetCapabilityNamesForGroupResponse")
	@WebMethod(action = "urn:getCapabilityNamesForGroup")
	public List<String> getCapabilityNamesForGroup(
			@WebParam(name = "groupName", targetNamespace = "http://tcs.service.optus.net/xsd") String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getUserAgentForMakeModel")
	@RequestWrapper(localName = "getUserAgentForMakeModel", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetUserAgentForMakeModel")
	@ResponseWrapper(localName = "getUserAgentForMakeModelResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetUserAgentForMakeModelResponse")
	@WebMethod(action = "urn:getUserAgentForMakeModel")
	public String getUserAgentForMakeModel(
			@WebParam(name = "make", targetNamespace = "http://tcs.service.optus.net/xsd") String make,
			@WebParam(name = "model", targetNamespace = "http://tcs.service.optus.net/xsd") String model) {
		// TODO Auto-generated method stub
		return "fake user agent1";
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getCapabilitiesForUserAgentAndGroup")
	@RequestWrapper(localName = "getCapabilitiesForUserAgentAndGroup", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetCapabilitiesForUserAgentAndGroup")
	@ResponseWrapper(localName = "getCapabilitiesForUserAgentAndGroupResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetCapabilitiesForUserAgentAndGroupResponse")
	@WebMethod(action = "urn:getCapabilitiesForUserAgentAndGroup")
	public List<OptusCapability> getCapabilitiesForUserAgentAndGroup(
			@WebParam(name = "ua", targetNamespace = "http://tcs.service.optus.net/xsd") String ua,
			@WebParam(name = "groupID", targetNamespace = "http://tcs.service.optus.net/xsd") String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	@WebResult(name = "getAllOptusApplicationsResponse", targetNamespace = "http://tcs.service.optus.net/xsd", partName = "part1")
	@Action(input = "urn:getAllOptusApplications")
	@WebMethod(action = "urn:getAllOptusApplications")
	public GetAllOptusApplicationsResponse getAllOptusApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getOptusApplicationsForMakeAndModel")
	@RequestWrapper(localName = "getOptusApplicationsForMakeAndModel", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetOptusApplicationsForMakeAndModel")
	@ResponseWrapper(localName = "getOptusApplicationsForMakeAndModelResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetOptusApplicationsForMakeAndModelResponse")
	@WebMethod(action = "urn:getOptusApplicationsForMakeAndModel")
	public List<OptusApplication> getOptusApplicationsForMakeAndModel(
			@WebParam(name = "make", targetNamespace = "http://tcs.service.optus.net/xsd") String make,
			@WebParam(name = "model", targetNamespace = "http://tcs.service.optus.net/xsd") String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:findDeviceForMakeModel")
	@RequestWrapper(localName = "findDeviceForMakeModel", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.FindDeviceForMakeModel")
	@ResponseWrapper(localName = "findDeviceForMakeModelResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.FindDeviceForMakeModelResponse")
	@WebMethod(action = "urn:findDeviceForMakeModel")
	public OptusDevice findDeviceForMakeModel(
			@WebParam(name = "make", targetNamespace = "http://tcs.service.optus.net/xsd") String make,
			@WebParam(name = "model", targetNamespace = "http://tcs.service.optus.net/xsd") String model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:isApplicationSupportedByDevice")
	@RequestWrapper(localName = "isApplicationSupportedByDevice", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.IsApplicationSupportedByDevice")
	@ResponseWrapper(localName = "isApplicationSupportedByDeviceResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.IsApplicationSupportedByDeviceResponse")
	@WebMethod(action = "urn:isApplicationSupportedByDevice")
	public Boolean isApplicationSupportedByDevice(
			@WebParam(name = "ua", targetNamespace = "http://tcs.service.optus.net/xsd") String ua,
			@WebParam(name = "appName", targetNamespace = "http://tcs.service.optus.net/xsd") String appName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	@WebResult(name = "getAllGroupsResponse", targetNamespace = "http://tcs.service.optus.net/xsd", partName = "part1")
	@Action(input = "urn:getAllGroups")
	@WebMethod(action = "urn:getAllGroups")
	public GetAllGroupsResponse getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getDevicesForApplication")
	@RequestWrapper(localName = "getDevicesForApplication", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetDevicesForApplication")
	@ResponseWrapper(localName = "getDevicesForApplicationResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetDevicesForApplicationResponse")
	@WebMethod(action = "urn:getDevicesForApplication")
	public List<OptusDevice> getDevicesForApplication(
			@WebParam(name = "appName", targetNamespace = "http://tcs.service.optus.net/xsd") String appName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getAllModelsByMake")
	@RequestWrapper(localName = "getAllModelsByMake", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetAllModelsByMake")
	@ResponseWrapper(localName = "getAllModelsByMakeResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetAllModelsByMakeResponse")
	@WebMethod(action = "urn:getAllModelsByMake")
	public List<String> getAllModelsByMake(
			@WebParam(name = "make", targetNamespace = "http://tcs.service.optus.net/xsd") String make) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebResult(name = "return", targetNamespace = "http://tcs.service.optus.net/xsd")
	@Action(input = "urn:getOptusApplicationsForUseragent")
	@RequestWrapper(localName = "getOptusApplicationsForUseragent", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetOptusApplicationsForUseragent")
	@ResponseWrapper(localName = "getOptusApplicationsForUseragentResponse", targetNamespace = "http://tcs.service.optus.net/xsd", className = "net.optus.service.tcs.xsd.GetOptusApplicationsForUseragentResponse")
	@WebMethod(action = "urn:getOptusApplicationsForUseragent")
	public List<OptusApplication> getOptusApplicationsForUseragent(
			@WebParam(name = "ua", targetNamespace = "http://tcs.service.optus.net/xsd") String ua) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SOAPBinding(parameterStyle = ParameterStyle.BARE)
	@WebResult(name = "getMakesResponse", targetNamespace = "http://tcs.service.optus.net/xsd", partName = "part1")
	@Action(input = "urn:getMakes")
	@WebMethod(action = "urn:getMakes")
	public GetMakesResponse getMakes() {
		// TODO Auto-generated method stub
		return null;
	}

}
