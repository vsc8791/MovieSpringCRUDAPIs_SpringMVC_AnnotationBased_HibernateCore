package com.amigos.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Title is required")
	@Size(max = 255, message = "Title must be less than 255 characters")
	private String title;

	@Min(value = 1900, message = "Year should not be less than 1900")
	private int year;

	@NotBlank(message = "Genre is required")
	private String genre;

	@NotBlank(message = "Director is required")
	@Size(max = 255, message = "Director must be less than 255 characters")
	private String director;

	@DecimalMin(value = "0.0", message = "Rating should not be less than 0.0")
	@DecimalMax(value = "10.0", message = "Rating should not be greater than 10.0")
	private double rating;

	@Size(max = 255, message = "Language must be less than 255 characters")
	private String language;

	@Size(max = 255, message = "Country must be less than 255 characters")
	private String country;

	@Min(value = 1, message = "Duration should be at least 1 minute")
	private int durationMinutes;

	@Size(max = 1000, message = "Synopsis must be less than 1000 characters")
	private String synopsis;

	private boolean isAvailableIn3D;

	// actors is not validated here as it's a List<String>

	@NotBlank(message = "Actors cannot be null")
	@Size(max = 255, message = "Actors must be less than 255 characters")
	private String actors;

	@NotBlank(message = "Actresses cannot be null")
	@Size(max = 255, message = "Actresses must be less than 255 characters")
	private String actresses;

	@NotBlank(message = "Studio is required")
	@Size(max = 255, message = "Studio must be less than 255 characters")
	private String studio;

	@Min(value = 0, message = "Budget cannot be negative")
	private int budget;

	@NotBlank(message = "Distributor is required")
	@Size(max = 255, message = "Distributor must be less than 255 characters")
	private String distributor;

	@NotBlank(message = "Cinematographer is required")
	@Size(max = 255, message = "Cinematographer must be less than 255 characters")
	private String cinematographer;

	private boolean isReleased;

	@NotBlank(message = "Soundtrack composer is required")
	@Size(max = 255, message = "Soundtrack composer must be less than 255 characters")
	private String soundtrackComposer;

	public Movie() {
	}

	public Movie(Long id,
			@NotBlank(message = "Title is required") @Size(max = 255, message = "Title must be less than 255 characters") String title,
			@Min(value = 1900, message = "Year should not be less than 1900") int year,
			@NotBlank(message = "Genre is required") String genre,
			@NotBlank(message = "Director is required") @Size(max = 255, message = "Director must be less than 255 characters") String director,
			@DecimalMin(value = "0.0", message = "Rating should not be less than 0.0") @DecimalMax(value = "10.0", message = "Rating should not be greater than 10.0") double rating,
			@Size(max = 255, message = "Language must be less than 255 characters") String language,
			@Size(max = 255, message = "Country must be less than 255 characters") String country,
			@Min(value = 1, message = "Duration should be at least 1 minute") int durationMinutes,
			@Size(max = 1000, message = "Synopsis must be less than 1000 characters") String synopsis,
			boolean isAvailableIn3D,
			@NotBlank(message = "Actors cannot be null") @Size(max = 255, message = "Actors must be less than 255 characters") String actors,
			@NotBlank(message = "Actresses cannot be null") @Size(max = 255, message = "Actresses must be less than 255 characters") String actresses,
			@NotBlank(message = "Studio is required") @Size(max = 255, message = "Studio must be less than 255 characters") String studio,
			@Min(value = 0, message = "Budget cannot be negative") int budget,
			@NotBlank(message = "Distributor is required") @Size(max = 255, message = "Distributor must be less than 255 characters") String distributor,
			@NotBlank(message = "Cinematographer is required") @Size(max = 255, message = "Cinematographer must be less than 255 characters") String cinematographer,
			boolean isReleased,
			@NotBlank(message = "Soundtrack composer is required") @Size(max = 255, message = "Soundtrack composer must be less than 255 characters") String soundtrackComposer) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
		this.language = language;
		this.country = country;
		this.durationMinutes = durationMinutes;
		this.synopsis = synopsis;
		this.isAvailableIn3D = isAvailableIn3D;
		this.actors = actors;
		this.actresses = actresses;
		this.studio = studio;
		this.budget = budget;
		this.distributor = distributor;
		this.cinematographer = cinematographer;
		this.isReleased = isReleased;
		this.soundtrackComposer = soundtrackComposer;
	}

	public Movie(
			@NotBlank(message = "Title is required") @Size(max = 255, message = "Title must be less than 255 characters") String title,
			@Min(value = 1900, message = "Year should not be less than 1900") int year,
			@NotBlank(message = "Genre is required") String genre,
			@NotBlank(message = "Director is required") @Size(max = 255, message = "Director must be less than 255 characters") String director,
			@DecimalMin(value = "0.0", message = "Rating should not be less than 0.0") @DecimalMax(value = "10.0", message = "Rating should not be greater than 10.0") double rating,
			@Size(max = 255, message = "Language must be less than 255 characters") String language,
			@Size(max = 255, message = "Country must be less than 255 characters") String country,
			@Min(value = 1, message = "Duration should be at least 1 minute") int durationMinutes,
			@Size(max = 1000, message = "Synopsis must be less than 1000 characters") String synopsis,
			boolean isAvailableIn3D,
			@NotBlank(message = "Actors cannot be null") @Size(max = 255, message = "Actors must be less than 255 characters") String actors,
			@NotBlank(message = "Actresses cannot be null") @Size(max = 255, message = "Actresses must be less than 255 characters") String actresses,
			@NotBlank(message = "Studio is required") @Size(max = 255, message = "Studio must be less than 255 characters") String studio,
			@Min(value = 0, message = "Budget cannot be negative") int budget,
			@NotBlank(message = "Distributor is required") @Size(max = 255, message = "Distributor must be less than 255 characters") String distributor,
			@NotBlank(message = "Cinematographer is required") @Size(max = 255, message = "Cinematographer must be less than 255 characters") String cinematographer,
			boolean isReleased,
			@NotBlank(message = "Soundtrack composer is required") @Size(max = 255, message = "Soundtrack composer must be less than 255 characters") String soundtrackComposer) {
		super();
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.director = director;
		this.rating = rating;
		this.language = language;
		this.country = country;
		this.durationMinutes = durationMinutes;
		this.synopsis = synopsis;
		this.isAvailableIn3D = isAvailableIn3D;
		this.actors = actors;
		this.actresses = actresses;
		this.studio = studio;
		this.budget = budget;
		this.distributor = distributor;
		this.cinematographer = cinematographer;
		this.isReleased = isReleased;
		this.soundtrackComposer = soundtrackComposer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public boolean isAvailableIn3D() {
		return isAvailableIn3D;
	}

	public void setAvailableIn3D(boolean isAvailableIn3D) {
		this.isAvailableIn3D = isAvailableIn3D;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getActresses() {
		return actresses;
	}

	public void setActresses(String actresses) {
		this.actresses = actresses;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	public String getCinematographer() {
		return cinematographer;
	}

	public void setCinematographer(String cinematographer) {
		this.cinematographer = cinematographer;
	}

	public boolean isReleased() {
		return isReleased;
	}

	public void setReleased(boolean isReleased) {
		this.isReleased = isReleased;
	}

	public String getSoundtrackComposer() {
		return soundtrackComposer;
	}

	public void setSoundtrackComposer(String soundtrackComposer) {
		this.soundtrackComposer = soundtrackComposer;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", genre=" + genre + ", director=" + director
				+ ", rating=" + rating + ", language=" + language + ", country=" + country + ", durationMinutes="
				+ durationMinutes + ", synopsis=" + synopsis + ", isAvailableIn3D=" + isAvailableIn3D + ", actors="
				+ actors + ", actresses=" + actresses + ", studio=" + studio + ", budget=" + budget + ", distributor="
				+ distributor + ", cinematographer=" + cinematographer + ", isReleased=" + isReleased
				+ ", soundtrackComposer=" + soundtrackComposer + "]";
	}

}
