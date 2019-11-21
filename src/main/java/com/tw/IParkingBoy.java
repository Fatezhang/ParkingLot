package com.tw;

public interface IParkingBoy {

    /**
     * 停车 获取停车票
     *
     * @param car
     * @return ticket
     */
    Ticket park(Car car);

    /**
     * 取车 根据票 获取对应车牌车辆
     *
     * @param ticket
     * @return 车辆
     */
    Car pick(Ticket ticket);
}
