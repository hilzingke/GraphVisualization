

import java.util.ArrayList;
import java.util.List;

public class Host implements Comparable<Host> {
    private int personId;
    private String personName;
    //private int directRelations - zählen wie viele personen potentiell angesteckt werden könnten


    List<EdgeHost> inEdges = new ArrayList<EdgeHost>();
    List<EdgeHost> outEdges = new ArrayList<EdgeHost>();

    public int compareTo(Host n) {
        return Integer.valueOf(this.distanceToStart).
                compareTo(n.distanceToStart);
    }

    int distanceToStart = 10000;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public List<EdgeHost> getInEdges() {
        return inEdges;
    }

    public void setInEdges(List<EdgeHost> inEdges) {
        this.inEdges = inEdges;
    }

    public List<EdgeHost> getOutEdges() {
        return outEdges;
    }

    public void setOutEdges(List<EdgeHost> outEdges) {
        this.outEdges = outEdges;
    }

    public int getDistanceToStart() {
        return distanceToStart;
    }

    public void setDistanceToStart(int distanceToStart) {
        this.distanceToStart = distanceToStart;
    }

    public Host(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Host{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';

    }
}
