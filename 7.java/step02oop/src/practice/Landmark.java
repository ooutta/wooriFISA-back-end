package practice;

public class Landmark {
   private String name;
   private String city;
   private double lat; // latitude(위도)
   private double lon; // longitude(경도)
   private String season;
   private String category; // ex) 맛집, 카페, 관광지, 쇼핑
   private String openTime;
   private String closeTime;
   private String tel;
   
   // 기본 생성자
   public Landmark() {}
   
   public Landmark(String name, String city, double lat, double lon, String season, String category) {
      this.name = name;
      this.city = city;
      this.lat = lat;
      this.lon = lon;
      this.season = season;
      this.category = category;
   }

   public Landmark(String name, String city, double lat, double lon, String season, String category, String openTime,
         String closeTime, String tel) {
      this.name = name;
      this.city = city;
      this.lat = lat;
      this.lon = lon;
      this.season = season;
      this.category = category;
      this.openTime = openTime;
      this.closeTime = closeTime;
      this.tel = tel;
   }
   
   public boolean isOpened(String now) {
      // openTime < now < closeTime 이면 return true; 
      // 아니면 return false;      
	   return false;
   }

   public String getName() {
      return name;
   }

//   public void setName(String name) {
//      this.name = name;
//   }

   public String getCity() {
      return city;
   }

//   public void setCity(String city) {
//      this.city = city;
//   }

   public double getLat() {
      return lat;
   }

   public void setLat(double lat) {
      this.lat = lat;
   }

   public double getLon() {
      return lon;
   }

   public void setLon(double lon) {
      this.lon = lon;
   }

   public String getSeason() {
      return season;
   }

   public void setSeason(String season) {
      this.season = season;
   }

   public String getCategory() {
      return category;
   }

//   public void setCategory(String category) {
//      this.category = category;
//   }

   public String getOpenTime() {
      return openTime;
   }

   public void setOpenTime(String openTime) {
      this.openTime = openTime;
   }

   public String getCloseTime() {
      return closeTime;
   }

   public void setCloseTime(String closeTime) {
      this.closeTime = closeTime;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   @Override
   public String toString() {
      return "Landmark [name=" + name + ", city=" + city + ", lat=" + lat + ", lon=" + lon + ", season=" + season
            + ", category=" + category + ", openTime=" + openTime + ", closeTime=" + closeTime + ", tel=" + tel
            + "]";
   }
   
   
}