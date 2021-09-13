package com.EthicalClothingShop.EthicalClothing.ClothingLine;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clothes")
public class ClothingController {
    private ClothingService clothingService;

    // Constructor
    public ClothingController(ClothingService clothingService) {

        this.clothingService = clothingService;
    }

    //methods
    @GetMapping
    public List<ClothingItem> getAllClothingItems() {
        return clothingService.getClothingItems();
    }
//
//    @GetMapping("{clothingType}")
//    public List <ClothingItem> getClothingItemsByType(@PathVariable("clothingType") String clothingType) {
//        return clothingService.getClothingItemsOfSameType(clothingType);
//    }
//
//    @GetMapping("{clothingDescription}")
//    public ClothingItem getSingleClothingItem(@PathVariable("clothingDescription") String clothingDescription) {
//        return clothingService.getOneClothingItem(clothingDescription);
//    }

    @PostMapping
    public void addClothingItem(@RequestBody ClothingItem clothingItem) {
        clothingService.addClothingItem(clothingItem);
    }

    @DeleteMapping("{barcode}")
    public void removeAllClothingItemsOfSameBarcode(@PathVariable("barcode") int id) {
        clothingService.removeClothingItem(id);
    }
//
//    @PutMapping
//    public void editClothingItem(@RequestBody ClothingItem clothingItem)
//        clothingService.updateClothingItem(clothingItem);
//    }


}
