package com.globant.training.google.maps.device.endpoint.dtos.device;

import static com.globant.training.google.maps.core.endpoint.validation.DtoValidator.validate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.device.endpoint.dtos.device.factory.DeviceFactory;
import com.globant.training.google.maps.device.endpoint.dtos.device.factory.GpsFactory;
import com.globant.training.google.maps.device.endpoint.dtos.device.factory.RfidFactory;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.DeviceType;

/**
 * Device DTO.
 * 
 * @author gaston.aguilera
 */
public class DeviceDto implements Dto<Device, DeviceDto>, Serializable {

  private static final long serialVersionUID = 1L;

  private static final Map<DeviceType, DeviceFactory> deviceFactoryMap;
  static {
    deviceFactoryMap = new HashMap<DeviceType, DeviceFactory>();
    deviceFactoryMap.put(DeviceType.GPS, new GpsFactory());
    deviceFactoryMap.put(DeviceType.RFID, new RfidFactory());
  }

  private Long id;

  @NotNull
  private String name;

  @NotNull
  private DeviceType type;

  @NotNull
  private Map<String, String> attributtes;

  @Override
  public Device toEntity() {

    validate(this);

    return deviceFactoryMap.get(type).makeDevice(name, attributtes);
  }
  
  @Override
  public DeviceDto fromEntity(Device device) {
    this.id = device.getId();
    this.name = device.getName();
    this.type = device.getType();
    this.attributtes = device.getAttributes();
    return this;
  }

  public Long getId() {
    return id;
  }

  public DeviceType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Map<String, String> getAttributtes() {
    return attributtes;
  }

  public void setAttributtes(Map<String, String> attributtes) {
    this.attributtes = attributtes;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setType(DeviceType type) {
    this.type = type;
  }
  
}