package com.example.InventoryManager.Service;

import com.example.InventoryManager.Exception.ResourceNotFoundException;
import com.example.InventoryManager.Repository.CarPartRepository;
import com.example.InventoryManager.entity.CarPart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarPartService
{
    private final CarPartRepository carPartRepository;

    // We inject the repository into the service
    public CarPartService(CarPartRepository carPartRepository)
    {
        this.carPartRepository = carPartRepository;
    }

    public CarPart getPart(String partNumber)
    {
        return carPartRepository.findById(partNumber).orElseThrow(() ->
                new ResourceNotFoundException("Part with Part Number" + partNumber +
                        " not found"));
    }

    public void deleteById(String partNumber)
    {
        getPart(partNumber); //throws error if the part does not exist
        carPartRepository.deleteById(partNumber);
    }

    /*
    Here we get/retrieve the part, alter it and save it to update its properties.
    We do not have a method to directly alter something in the repository.
     */
    public CarPart reservePart(String partNumber, int numberOfUnits)
    {
        CarPart part = getPart(partNumber);

        if (numberOfUnits > part.getStock() - part.getReserved())
        {
            throw new IllegalArgumentException(" Not enough Units ");
        }
        else
        {
            part.setReserved(part.getReserved() + numberOfUnits);
            carPartRepository.save(part);
        }
        return part;
    }

    public List<CarPart> getAllParts()
    {
        return carPartRepository.findAll();
    }

    public CarPart addPart(CarPart part)
    {
        return carPartRepository.save(part);
    }

    // the threshold stands for the max no. of units available for an item
    // to be considered as low in stock
    public List<CarPart> getPartsLowStock(int threshold)
    {
        return carPartRepository.findLowStockParts(threshold);
    }

    public CarPart updatePart(CarPart part, String partNumber)
    {
        CarPart partToBeUpdated = getPart(partNumber);

        partToBeUpdated.setPartDescription(part.getPartDescription());
        partToBeUpdated.setGroupNumber(part.getGroupNumber());
        partToBeUpdated.setPrice(part.getPrice());
        partToBeUpdated.setStock(part.getStock());

       return carPartRepository.save(partToBeUpdated);
    }
}

