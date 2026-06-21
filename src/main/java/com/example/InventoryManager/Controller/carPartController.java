package com.example.InventoryManager.Controller;

import com.example.InventoryManager.entity.CarPart;
import com.example.InventoryManager.Service.CarPartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class carPartController
{
    private final CarPartService service;

    // We inject the service into the controller also called Constructor-Injection
    public carPartController(CarPartService service)
    {
        this.service = service;
    }

    @GetMapping("/parts")
    public List<CarPart> getAllParts()
    {
        return service.getAllParts();
    }

    @GetMapping("/parts/{partNumber}")
    public CarPart getPart(@PathVariable String partNumber)
    {
        return service.getPart(partNumber);
    }

    @PostMapping("/parts")
    public CarPart addPart(@RequestBody CarPart part)
    {
        return service.addPart(part);
    }

    @PutMapping("/parts/{partNumber}")
    public CarPart updatePart(@RequestBody CarPart part, @PathVariable String partNumber)
    {
        return service.updatePart(part, partNumber);
    }

    @DeleteMapping("/parts/{partNumber}")
    public void deleteById(@PathVariable String partNumber)
    {
        service.deleteById(partNumber);
    }

    @GetMapping("/parts/lowstock")
    public List<CarPart> getPartsLowStock(@RequestParam int threshold)
    {
        return service.getPartsLowStock(threshold);
    }

    @PutMapping("parts/{partNumber}/reserve")
    public CarPart reservePart(@PathVariable String partNumber,
                               @RequestParam int numberOfUnits)
    {
        return service.reservePart(partNumber, numberOfUnits);
    }
}
