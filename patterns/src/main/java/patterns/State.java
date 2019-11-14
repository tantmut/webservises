package patterns;

public class State {

    public static void main(String[] args) {

        Station station = new StationDigital();

        Radio radio = new Radio();
        radio.setStation(station);

        for(int i = 0; i< 10; i++){
            radio.play();
            radio.nextStation();
        }
    }

    interface Station {
        void play();
    }

    public static class StationVesti implements Station {

        @Override
        public void play() {
            System.out.println("Station Vesti");
        }
    }

    public static class StationDigital implements Station {

        @Override
        public void play() {
            System.out.println("Station Digital");
        }
    }

    public static class StationOpera implements Station {

        @Override
        public void play() {
            System.out.println("Station Opera ");
        }
    }

    public static class Radio {

        Station station;

        public void setStation(Station station) {
            this.station = station;
        }

        public void nextStation() {

            if (station instanceof StationVesti) {
                setStation(new StationDigital());
            } else if (station instanceof StationDigital) {
                setStation(new StationOpera());
            } else if (station instanceof StationOpera) {
                setStation(new StationVesti());
            }
        }

        public void play() {
            station.play();
        }
    }
}
