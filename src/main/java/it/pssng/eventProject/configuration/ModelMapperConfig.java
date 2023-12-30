package it.pssng.eventProject.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // modelMapper.typeMap(ArtWork.class, ArtworkDTO.class).addMappings(mapper -> {
        //     mapper.map(ArtWork::getNumberOfWorks, ArtworkDTO::setNumberOfWorks);
        //     mapper.map(ArtWork::getMaximumCapacity, ArtworkDTO::setMaximumCapacity);
        //     mapper.map(ArtWork::getArtworkTheme, ArtworkDTO::setArtworkTheme);
        //     mapper.map(ArtWork::getDescription, ArtworkDTO::setDescription);
        //     mapper.map(ArtWork::getLocation, ArtworkDTO::setLocation);
        //     mapper.map(ArtWork::getDateAndTime, ArtworkDTO::setDateAndTime);

        // });

        // modelMapper.typeMap(ArtworkDTO.class, ArtWork.class).addMappings(mapper -> {
        //     mapper.map(ArtworkDTO::getNumberOfWorks, ArtWork::setNumberOfWorks);
        //     mapper.map(ArtworkDTO::getMaximumCapacity, ArtWork::setMaximumCapacity);
        //     mapper.map(ArtworkDTO::getArtworkTheme, ArtWork::setArtworkTheme);
        //     mapper.map(ArtworkDTO::getDescription, ArtWork::setDescription);
        //     mapper.map(ArtworkDTO::getLocation, ArtWork::setLocation);
        //     mapper.map(ArtworkDTO::getDateAndTime, ArtWork::setDateAndTime);
        //     mapper.skip(ArtWork::setExhibitionCode);
        // });

        return modelMapper;
    }

}