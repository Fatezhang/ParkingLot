package com.tw;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public abstract class AbstractParkingBoy implements IParkingBoy {

    private IStrategyHandler strategyHandler;

    @Override
    public Ticket park(Car car) {
        return strategyHandler.chooseParkingLot().park(car);
    }

    @Override
    public Car pick(Ticket ticket) {
        ParkingLot parkingLot = this.getParkingLots().stream().filter(lot -> lot.getId() == ticket.getParkingLotId()).collect(Collectors.<ParkingLot>toList()).get(0);
        return parkingLot.getCar(ticket);
    }

    protected abstract List<ParkingLot> getParkingLots();

    /**
     * 初始化选取停车场的策略
     *
     * @param strategyHandler
     */
    protected void initStrategy(IStrategyHandler strategyHandler) {
        this.strategyHandler = strategyHandler;
    }


    public static class GradStrategy implements IStrategyHandler {

        private List<ParkingLot> parkingLots;

        public GradStrategy(List<ParkingLot> parkingLots) {
            this.parkingLots = parkingLots;
        }

        @Override
        public ParkingLot chooseParkingLot() {
            List<ParkingLot> parkingLots = this.parkingLots.stream().filter(lot -> lot.getCurrentParkNum() < lot.getSize()).collect(Collectors.toList());
            if (parkingLots.isEmpty()) {
                throw new RuntimeException("No carports to park");
            }
            return parkingLots.get(0);
        }
    }

    public static class SmartStrategy implements IStrategyHandler {

        private List<ParkingLot> parkingLots;

        public SmartStrategy(List<ParkingLot> parkingLots) {
            this.parkingLots = parkingLots;
        }

        @Override
        public ParkingLot chooseParkingLot() {
            return parkingLots.stream().filter(lot -> lot.getCurrentParkNum() < lot.getSize()).max(comparing(ParkingLot::getRemainingParkNum)).get();
        }
    }

    public static class ManagerStrategy implements IStrategyHandler {

        private List<ParkingLot> parkingLots;

        public ManagerStrategy(List<ParkingLot> parkingLots) {
            this.parkingLots = parkingLots;
        }

        @Override
        public ParkingLot chooseParkingLot() {
            return null;
        }


    }


}
