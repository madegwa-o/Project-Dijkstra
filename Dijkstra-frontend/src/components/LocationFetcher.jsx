import { useState } from "react";

const LocationFetcher = () => {
    const [location, setLocation] = useState(null);
    const [error, setError] = useState(null);

    const getLocation = () => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(
                (position) => {
                    const { latitude, longitude } = position.coords;
                    setLocation({ latitude, longitude });
                    setError(null);
                },
                (error) => {
                    setError(error.message);
                    setLocation(null);
                }
            );
        } else {
            setError("Geolocation is not supported by this browser.");
        }
    };

    return (
        <div>
            <button onClick={getLocation}>Get My Location</button>
            {location && (
                <p>
                    🌍 Latitude: {location.latitude}, Longitude: {location.longitude}
                </p>
            )}
            {error && <p style={{ color: "red" }}>{error}</p>}
        </div>
    );
};

export default LocationFetcher;
