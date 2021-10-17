package id.go.lan.pusaka.ikksurvey.service;

import id.go.lan.pusaka.ikksurvey.model.AgendaSetting;

public interface AgendaSettingService {
	public AgendaSetting save(AgendaSetting agendaSetting);

	public AgendaSetting findById(Long id);
}
