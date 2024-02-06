package F1.Backend;

public abstract class Driver {
    //Fields
    private String Name;
    private String Team;
    private String Location;

    //Getters and Setters

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    //Methods
    public String toString(){
        return ">>> Name is : "+ this.getName() +" Location is : "+ this.getLocation()+" Team is "+this.getTeam();
    }
}
