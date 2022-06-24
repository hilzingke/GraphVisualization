
public class EdgeHost {
    public EdgeHost(Host startHost, Host endHost, int distance) {
        super();
        this.startHost = startHost;
        this.endHost = endHost;
        this.distance = distance;
        startHost.outEdges.add(this);
        endHost.inEdges.add(this);
    }

    Host startHost;
    Host endHost;
    int distance;

    public EdgeHost(Host startHost, Integer key, Integer value) {
    }

    public Host getStartHost() {
        return startHost;
    }

    public void setStartHost(Host startHost) {
        this.startHost = startHost;
    }

    public Host getEndHost() {
        return endHost;
    }

    public void setEndHost(Host endHost) {
        this.endHost = endHost;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
