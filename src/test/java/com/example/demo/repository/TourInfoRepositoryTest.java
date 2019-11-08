package com.example.demo.repository;

import com.example.demo.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class TourInfoRepositoryTest {
    @Autowired
    private TourInfoRepository tourInfoRepository;
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private LocalityRepository localityRepository;
    @Autowired
    private BuroRepository buroRepository;
    @Autowired
    private OfficeRepository officeRepository;

    @Test
    public void saveSuccess() {
        Buro buro = new Buro();
        buro.setAddress("Address");
        buro.setFio("F I O");
        buro.setName("Name");
        buro.setPhone(1234567);
        buro.setId(buroRepository.save(buro).getId());

        Office office = new Office();
        office.setBuro(buro);
        office.setOffice_address("Address office");
        office.setId(officeRepository.save(office).getId());

        Office office1 = new Office();
        office1.setBuro(buro);
        office1.setOffice_address("Address office 1");
        office1.setId(officeRepository.save(office1).getId());

        Locality locality = new Locality();
        locality.setName("GE");
        locality.setId(localityRepository.save(locality).getId());

        Hotel hotel = new Hotel();
        hotel.setLocality(locality);
        hotel.setName("Ho Tel");
        hotel.setStars(4);
        hotel.setId(hotelRepository.save(hotel).getId());

        Hotel hotel1 = new Hotel();
        hotel1.setLocality(locality);
        hotel1.setName("Hot El");
        hotel1.setStars(3);
        hotel1.setId(hotelRepository.save(hotel1).getId());

        Tour tour = new Tour();
        tour.setNight(21);
        tour.setOffice(office);
        tour.setTourType(TourType.SHOP_TOUR);
        tour.setId(tourRepository.save(tour).getId());

        TourInfo tourInfo = new TourInfo();
        tourInfo.setHotel(hotel);
        tourInfo.setDeparturePoint("Departure Point");
        tourInfo.setPrice(1234);
        tourInfo.setTour(tour);
        tourInfo.setTransport(Transport.BUS);
        tourInfo.setId(tourInfoRepository.save(tourInfo).getId());

        //buroRepository.findBuroByName("Name");
        Assert.assertEquals(2, officeRepository.findByBuro(buro).size());
    }
}