import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private String name;
    private int id;
    private int overall;
    private String nation;
    private int age;
    private String team_name;
    private String league;
    private int height;
    private HashMap<String, String> canPlay = new HashMap<>();
    public HashMap<String, String> getCanPlay() {
        return this.canPlay;
    }
    public Player(String name, int id, float overall, String nation, int age, String team_name, String league, String position) {
        this.name = name;
        this.id = id;
        this.overall = (int) overall;
        this.nation = nation;
        this.age = age;
        this.team_name = team_name;
        this.height = height;
        this.league = league;
        this.positions = new ArrayList<>();
        this.positions.add(position);
    }
    public void addPosition(String position) {
        if (!this.positions.contains(position)) {
            this.positions.add(position);
        }
    }
    public void setCanPlay(String abs, String form) {
        ArrayList<String> canplayat = new ArrayList<>();
        canplayat.addAll(List.of(abs.split(",")));
        switch(form){
            case "3-4-3":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("LW")) canPlay.put("LW","1");
                if(canplayat.contains("RW")) canPlay.put("RW","2");
                if(canplayat.contains("LM")) canPlay.put("LM","3");
                if(canplayat.contains("CM")) canPlay.put("CM","4,5");
                if(canplayat.contains("RM")) canPlay.put("RM","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "3-4-1-2":
                if(canplayat.contains("CAM")) canPlay.put("CAM","0");
                if(canplayat.contains("ST")) canPlay.put("ST","1,2");
                if(canplayat.contains("LM")) canPlay.put("LM","3");
                if(canplayat.contains("CM")) canPlay.put("CM","4,5");
                if(canplayat.contains("RM")) canPlay.put("RM","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "3-4-2-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0,1,2");
                if(canplayat.contains("LM")) canPlay.put("LM","3");
                if(canplayat.contains("CM")) canPlay.put("CM","4,5");
                if(canplayat.contains("RM")) canPlay.put("RM","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "3-5-2":
                if(canplayat.contains("CAM")) canPlay.put("CAM","0");
                if(canplayat.contains("ST")) canPlay.put("ST","1,2");
                if(canplayat.contains("LM")) canPlay.put("LM","3");
                if(canplayat.contains("CDM")) canPlay.put("CDM","4,5");
                if(canplayat.contains("RM")) canPlay.put("RM","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-1-2-1-2":
                if(canplayat.contains("CAM")) canPlay.put("CAM","0");
                if(canplayat.contains("ST")) canPlay.put("ST","1,2");
                if(canplayat.contains("LM")) canPlay.put("LM","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RM")) canPlay.put("RM","6");
                if(canplayat.contains("LB")) canPlay.put("LB","7");
                if(canplayat.contains("CDM")) canPlay.put("CDM","8");
                if(canplayat.contains("RB")) canPlay.put("RB","9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-1-4-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("CM")) canPlay.put("CM","1,2");
                if(canplayat.contains("LM")) canPlay.put("LM","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RM")) canPlay.put("RM","6");
                if(canplayat.contains("LB")) canPlay.put("LB","7");
                if(canplayat.contains("CDM")) canPlay.put("CDM","8");
                if(canplayat.contains("RB")) canPlay.put("RB","9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-2-2-2":
                if(canplayat.contains("ST")) canPlay.put("ST","0,1");
                if(canplayat.contains("CDM")) canPlay.put("CDM","2,8");
                if(canplayat.contains("CAM")) canPlay.put("CAM","3,6");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("LB")) canPlay.put("LB","7");
                if(canplayat.contains("RB")) canPlay.put("RB","9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;
            case "4-2-3-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("CAM")) canPlay.put("CAM","1,2,8");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CDM")) canPlay.put("CDM","7,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-3-1-2":
                if(canplayat.contains("CAM")) canPlay.put("CAM","0");
                if(canplayat.contains("ST")) canPlay.put("ST","1,2");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CM")) canPlay.put("CM","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-3-2-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0,1,2");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CM")) canPlay.put("CM","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-3-3":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("LW")) canPlay.put("LW","1");
                if(canplayat.contains("RW")) canPlay.put("RW","2");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CM")) canPlay.put("CM","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-4-1-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("LM")) canPlay.put("LM","1");
                if(canplayat.contains("RM")) canPlay.put("RM","2");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CM")) canPlay.put("CM","7,9");
                if(canplayat.contains("CAM")) canPlay.put("CAM","8");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-4-2":
                if(canplayat.contains("ST")) canPlay.put("ST","0,8");
                if(canplayat.contains("LM")) canPlay.put("LM","1");
                if(canplayat.contains("RM")) canPlay.put("RM","2");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CM")) canPlay.put("CM","7,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "4-5-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("LM")) canPlay.put("LM","1");
                if(canplayat.contains("RM")) canPlay.put("RM","2");
                if(canplayat.contains("LB")) canPlay.put("LB","3");
                if(canplayat.contains("CB")) canPlay.put("CB","4,5");
                if(canplayat.contains("RB")) canPlay.put("RB","6");
                if(canplayat.contains("CAM")) canPlay.put("CAM","7,9");
                if(canplayat.contains("CM")) canPlay.put("CM","8");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "5-2-2-1":
                if(canplayat.contains("ST")) canPlay.put("ST","0");
                if(canplayat.contains("LW")) canPlay.put("LW","1");
                if(canplayat.contains("RW")) canPlay.put("RW","2");
                if(canplayat.contains("LWB")) canPlay.put("LWB","3");
                if(canplayat.contains("CM")) canPlay.put("CM","4,5");
                if(canplayat.contains("RWB")) canPlay.put("RWB","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "5-2-1-2":
                if(canplayat.contains("CAM")) canPlay.put("CAM","0");
                if(canplayat.contains("ST")) canPlay.put("ST","1,2");
                if(canplayat.contains("LWB")) canPlay.put("LWB","3");
                if(canplayat.contains("CM")) canPlay.put("CM","4,5");
                if(canplayat.contains("RWB")) canPlay.put("RWB","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;

            case "5-3-2":
                if(canplayat.contains("CM")) canPlay.put("CM","0,4,5");
                if(canplayat.contains("ST")) canPlay.put("ST","1,2");
                if(canplayat.contains("LWB")) canPlay.put("LWB","3");
                if(canplayat.contains("RWB")) canPlay.put("RWB","6");
                if(canplayat.contains("CB")) canPlay.put("CB","7,8,9");
                if(canplayat.contains("GK")) canPlay.put("GK","10");
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    private boolean foot;
    private HashMap<String, Integer> skills;
    public HashMap<String, Integer> getSkills(){
        return this.skills;
    }
    public void setSkills(HashMap<String, Integer> skills){
        this.skills = skills;
    }
    public boolean isFoot() {
        return foot;
    }

    public void setFoot(boolean foot) {
        this.foot = foot;
    }
    private ArrayList<String> positions;

    public ArrayList<String> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<String> positions) {
        this.positions = positions;
    }
    public String toString(){
        return "Name: " + this.name + " Team: "+ this.team_name +" ID:" + String.valueOf(this.id) + " Overall:" + String.valueOf(this.overall);
    }
}
