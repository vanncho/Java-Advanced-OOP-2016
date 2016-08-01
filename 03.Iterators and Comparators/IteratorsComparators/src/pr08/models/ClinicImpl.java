package pr08.models;

import pr08.interfaces.Clinic;
import pr08.interfaces.Pet;

public class ClinicImpl implements Clinic {

    private Pet[] rooms;
    private int clinicRooms;
    private int freeRooms;

    public ClinicImpl(int clinicRooms) {
        this.setRooms(new Pet[clinicRooms]);
        this.clinicRooms = clinicRooms;
        this.freeRooms = clinicRooms;
    }

    private void setRooms(Pet[] rooms) {

        if (rooms.length % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        this.rooms = rooms;
    }

    @Override
    public boolean add(Pet pet) {
        int currentRoom = this.rooms.length / 2;
        int step = 0;

        if (this.rooms[currentRoom] == null) {
            this.rooms[currentRoom] = pet;
            this.freeRooms--;
            return true;
        }
        
        step++;
        boolean isAddedPet = false;

        while (step <= currentRoom) {
            
            // check left
            for (int i = 0; i < 1; i++) {

                if (this.rooms[currentRoom - step] == null) {

                    this.rooms[currentRoom - step] = pet;
                    isAddedPet = true;
                    this.freeRooms--;
                    break;
                }
            }

            if (isAddedPet) {
                break;
            }
            
            // check right
            for (int i = 0; i < 1; i++) {

                if (this.rooms[currentRoom + step] == null) {

                    this.rooms[currentRoom + step] = pet;
                    isAddedPet = true;
                    this.freeRooms--;
                    break;
                }
            }

            if (isAddedPet) {
                break;
            }

            step++;
        }

        return isAddedPet;
    }

    @Override
    public boolean release() {
        int currentRoom = this.rooms.length / 2;

        if (this.rooms[currentRoom] != null) {
            this.rooms[currentRoom] = null;
            this.freeRooms++;
            return true;
        }

        // check left
        for (int i = currentRoom + 1; i < this.rooms.length; i++) {

            if (this.rooms[i] != null) {

                this.rooms[i] = null;
                this.freeRooms++;
                return true;
            }
        }

        // check right
        for (int i = 0; i < currentRoom; i++) {

            if (this.rooms[i] != null) {

                this.rooms[i] = null;
                this.freeRooms++;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        return this.freeRooms > 0;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.rooms.length; i++) {

            if (this.rooms[i] == null) {
                sb.append("Room empty");
            } else {
                sb.append(this.rooms[i]);
            }

            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String print(int room) {

        if (this.rooms[room - 1] == null) {
            return "Room empty";
        }

        return this.rooms[room - 1].toString();
    }
}
