/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geographic;


public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries> {

    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-12s%-12s%-25.1f%-12s\n",this.countryCode, this.countryName, this.totalArea,this.countryTerrain);
    }

    @Override
    public int compareTo(EastAsiaCountries t) {
        return this.getCountryName().compareTo(t.getCountryName());
    }
}
