import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) {
            if (f.satisfies(qe)) {
                answer.add(qe);
            }
        }

        return answer;
    }

    public void quakesWithFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        //Filter f = new MinMagFilter(4.0);
        //Filter f1 = new MagnitudeFilter(4.0, 6.0);
        Filter f2 = new DepthFilter(-35000.00, -12000);
        Location japan = new Location(35.42, 139.43);
        Filter f4 = new PhraseFilter("end", "Japan");
        Filter f3 = new DistanceFilter(japan, 10000000.0);
        ArrayList<QuakeEntry> m7  = filter(list, f3);
        m7 = filter(m7, f4);
        for (QuakeEntry qe: m7) {
            System.out.println(qe);
        }
        System.out.println("Found " + m7.size() + " quakes that match that criteria\n");
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }
    }

    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedatasmall.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //for (QuakeEntry qe: list){
        //    System.out.println(qe);
        //}
        MatchAllFilter maf = new MatchAllFilter();
       maf.addFilter(new MagnitudeFilter(0.0, 5.0));
       Location Denmark = new Location(55.7308, 9.1153);
       maf.addFilter(new DistanceFilter(Denmark, 3000000 ));
       maf.addFilter(new PhraseFilter("any", "e"));
      //   maf.addFilter(new DepthFilter(-180000, -30000.0));
        ArrayList<QuakeEntry> m7 = filter(list, maf);
        for (QuakeEntry qe : m7){
            System.out.println(qe);
        }
        System.out.println("There were: "+m7.size()+" that met that criteria\n");
        System.out.println("The filters used where \n" + maf.getName() + "\n");

    }

}
