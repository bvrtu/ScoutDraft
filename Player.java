import java.util.HashMap;

public class Player {
    private String name;
    private float id;
    private int overall;
    private String nation;
    private int age;
    private String team_name;
    private String league;
    private int height;

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
    public HashMap getSkills(){
        return this.skills;
    }
    public void setSkills(HashMap skills){
        this.skills = skills;
    }
    public boolean isFoot() {
        return foot;
    }

    public void setFoot(boolean foot) {
        this.foot = foot;
    }
}
