package id.go.lan.pusaka.ikksurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.go.lan.pusaka.ikksurvey.model.AgendaSetting;
import id.go.lan.pusaka.ikksurvey.repository.AgendaSettingRepository;
import id.go.lan.pusaka.ikksurvey.service.AgendaSettingService;

@Service
public class AgendaSettingServiceImpl implements AgendaSettingService {
	@Autowired
	AgendaSettingRepository agendaSettingRepository;

	@Override
	public AgendaSetting save(AgendaSetting agendaSetting) {
		// TODO Auto-generated method stub
		return agendaSettingRepository.save(agendaSetting);
	}

	@Override
	public AgendaSetting findById(Long id) {
		// TODO Auto-generated method stub
		return agendaSettingRepository.findById(id).orElse(null);
	}

}
