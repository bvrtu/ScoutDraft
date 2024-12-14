import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {
    private String name;
    private float id;
    private int overall;
    private String nation;
    private int age;
    private String team_name;
    private String league;
    private int height;
    private HashMap<String, Integer> canPlay = new HashMap<>();
    public HashMap<String, Integer> getCanPlay() {
        return this.canPlay;
    }
    public Player(String name, float id, float overall, String nation, int age, String team_name, int height) {
        this.name = name;
        this.id = id;
        this.overall = (int) overall;
        this.nation = nation;
        this.age = age;
        this.team_name = team_name;
        this.height = height;
    }
    public void setCanPlay(String abs, String form) {
        ArrayList<String> canplayat = new ArrayList<>();
        canplayat.addAll(List.of(abs.split(",")));
        switch(form){
            case "3-4-3":
                if(canplayat.contains("ST")){
                    canPlay.put("ST",0);
                }

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
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
        return "Name: " + this.name + " ID:" + String.valueOf(this.id) + " Overall:" + String.valueOf(this.overall);
    }
}
