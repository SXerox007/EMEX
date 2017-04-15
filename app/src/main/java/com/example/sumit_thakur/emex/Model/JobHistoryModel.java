package com.example.sumit_thakur.emex.Model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model class Job History Model
 */
public class JobHistoryModel implements Parcelable {
    public static final Creator<JobHistoryModel> CREATOR = new Creator<JobHistoryModel>() {
        @Override
        public JobHistoryModel createFromParcel(final Parcel in) {
            return new JobHistoryModel(in);
        }

        @Override
        public JobHistoryModel[] newArray(final int size) {
            return new JobHistoryModel[size];
        }
    };
    private String driverName;
    private String distanceCover, dateAndTime, pickupAddress, destinationAddress, totalRideTime, totalAmounttoBePaid;

    /**
     * @param driverName          driver name
     * @param distanceCover       distance cover
     * @param dateAndTime         date and time
     * @param pickupAddress       pickup address
     * @param destinationAddress  destination Address
     * @param totalRideTime       total ride time
     * @param totalAmounttoBePaid total Amount paid
     */
    public JobHistoryModel(final String driverName, final String distanceCover,
                           final String dateAndTime, final String pickupAddress, final String destinationAddress,
                           final String totalRideTime, final String totalAmounttoBePaid) {
        this.dateAndTime = dateAndTime;
        this.distanceCover = distanceCover;
        this.driverName = driverName;
        this.pickupAddress = pickupAddress;
        this.destinationAddress = destinationAddress;
        this.totalRideTime = totalRideTime;
        this.totalAmounttoBePaid = totalAmounttoBePaid;
    }

    /**
     *
     * @param in Parcel
     */
    protected JobHistoryModel(final Parcel in) {
        driverName = in.readString();
        distanceCover = in.readString();
        dateAndTime = in.readString();
        pickupAddress = in.readString();
        destinationAddress = in.readString();
        totalRideTime = in.readString();
        totalAmounttoBePaid = in.readString();
    }


    /**
     * @return total Anount to be paid
     */
    public String getTotalAmounttoBePaid() {
        return totalAmounttoBePaid;
    }

    /**
     * @return driver name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @return total distance cover
     */
    public String getDistanceCover() {
        return distanceCover;
    }

    /**
     * @return date and time
     */
    public String getDateAndTime() {
        return dateAndTime;
    }

    /**
     * @return Pickup address
     */
    public String getPickupAddress() {
        return pickupAddress;
    }

    /**
     * @return Destination Address
     */
    public String getDestinationAddress() {
        return destinationAddress;
    }

    /**
     * @return total ride time
     */
    public String getTotalRideTime() {

        return totalRideTime;
    }

    /**
     * @param driverName driver name set
     */
    public void setDriverName(final String driverName) {
        this.driverName = driverName;
    }

    /**
     * @param distanceCover total distance set
     */
    public void setDistanceCover(final String distanceCover) {
        this.distanceCover = distanceCover;
    }

    /**
     * @param dateAndTime date and time set
     */
    public void setDateAndTime(final String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    /**
     * @param pickupAddress pickup address set
     */
    public void setPickupAddress(final String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    /**
     * @param destinationAddress destination address set
     */
    public void setDestinationAddress(final String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    /**
     * @param totalRideTime total Ride time Set
     */
    public void setTotalRideTime(final String totalRideTime) {
        this.totalRideTime = totalRideTime;
    }

    /**
     * @param totalAmounttoBePaid total amount
     */
    public void setTotalAmounttoBePaid(final String totalAmounttoBePaid) {
        this.totalAmounttoBePaid = totalAmounttoBePaid;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(driverName);
        dest.writeString(distanceCover);
        dest.writeString(dateAndTime);
        dest.writeString(pickupAddress);
        dest.writeString(destinationAddress);
        dest.writeString(totalRideTime);
        dest.writeString(totalAmounttoBePaid);
    }
}
