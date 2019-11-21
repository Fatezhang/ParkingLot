package com.tw;

import java.util.List;
import java.util.stream.Collectors;

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


    public static class gradStrategy implements IStrategyHandler {

        private List<ParkingLot> parkingLots;

        public gradStrategy(List<ParkingLot> parkingLots) {
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

    public static class smartStrategy implements IStrategyHandler {

        @Override
        public ParkingLot chooseParkingLot() {
            return null;
        }


    }


}
