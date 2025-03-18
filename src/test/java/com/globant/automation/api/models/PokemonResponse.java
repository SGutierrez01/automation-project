package com.globant.automation.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {

  private int id;
  private String name;
  private int height;
  private int weight;
  private List<TypeSlot> types;

  @Data
  public static class TypeSlot {
    private int slot;
    private Type type;
  }

  @Data
  public static class Type {
    private String name;
    private String url;
  }
}

