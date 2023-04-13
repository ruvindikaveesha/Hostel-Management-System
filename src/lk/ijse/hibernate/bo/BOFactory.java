package lk.ijse.hibernate.bo;

import lk.ijse.hibernate.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOimpl();
            case ROOM:
                return (T) new RoomBOimpl();
            case RESERVATION:
                return (T) new ReservationBOimpl();
            case PERCHASE_RESERVE:
                return (T) new PurchaseReserveBOimpl();
            case USER:
                return (T) new UserBOimpl();
            default:
                return null;
        }
    }

}

