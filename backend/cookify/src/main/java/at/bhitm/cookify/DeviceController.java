package at.bhitm.cookify;

import at.bhitm.entities.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("device")
public class DeviceController {

    @Autowired
    private DeviceRepository repository;

    @GetMapping()
    public List<Device> findAll() {
        return repository.findAll();
    }

    @GetMapping("/insertTestData")
    public List<Device> insertTestData() {

        Device d = new Device("Manuel Device", "2019-01-24T08:06:23+00:00");
        Device d1 = new Device("OnePlus 3", "2019-02-24T08:06:23+00:00");

        repository.save(d);
        repository.save(d1);

        return repository.findAll();

    }

    @PostMapping()
    public Device insertDevice(@RequestBody Device device) {
        return repository.save(device);
    }

    @PutMapping()
    public Device updateDevice(@RequestBody Device device) {
        Device d = repository.findById(device.getDeviceID()).orElse(null);
        if (d == null) {
            //return new NotFoundException();
        }
        return repository.save(device);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteDevice(@PathVariable String id) {
        Device deviceFromId = repository.findById(id).orElse(null);
        repository.delete(deviceFromId);
    }

}
