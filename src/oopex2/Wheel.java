package oopex2;

/**
 * The Wheel represents a wheel with a kilometre usage, tread condition, size, and season.
 * 
 * @author Inglume
 */
public class Wheel {
  private String brand;
  private String model;
  private int size;
  private String season;
  private int KM_usage;
  private String tread_condition;

  /**
   * Default constructor for a {@link Wheel}.
   * 
   * @param br
   * @param mod
   * @param siz
   * @param sea
   */
  public Wheel(String br, String mod, int siz, String sea) {
    brand = br;
    model = mod;
    size = siz;
    season = sea;
    KM_usage = 0;
    tread_condition = "";
  }

  /**
   * Adds km to KM_usage
   * 
   * @param km
   */
  public void update_KM_usage(int km) {
    KM_usage += km;
  }

  /**
   * Gets wheel brand.
   * 
   * @return String - brand
   */
  public String getBrand() {
    return brand;
  }

  /**
   * Gets wheel model.
   * 
   * @return String - model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets wheel size.
   * 
   * @return int - size
   */
  public int getSize() {
    return size;
  }

  /**
   * Gets tire season.
   * 
   * @return String - season
   */
  public String getSeason() {
    return season;
  }

  /**
   * Gets kilometre usage.
   * 
   * @return KM_usage
   */
  public int getKM() {
    return KM_usage;
  }
}
