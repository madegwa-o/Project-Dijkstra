import './App.css';
import BarChart from "./components/BarChart.jsx";
import Map from "./components/Map.jsx";
import LocationFetcher from "./components/LocationFetcher.jsx";

function App() {
    const data = [
        { name: "A", value: 49 },
        { name: "B", value: 80 },
        { name: "C", value: 45 },
        { name: "D", value: 60 },
        { name: "E", value: 20 },
        { name: "F", value: 90 },
        { name: "G", value: 50 },
    ];

    // Mock data for the Map
    const coordinates = [
        { label: "A", x: 50, y: 350 },
        { label: "B", x: 150, y: 120 },
        { label: "C", x: 250, y: 80 },
        { label: "D", x: 350, y: 200 },
        { label: "E", x: 40, y: 260 },
        { label: "F", x: 350, y: 430 },
        { label: "G", x: 117, y: 10 },
        { label: "H", x: 201, y: 18 },
        { label: "I", x: 350, y: 56 },
        { label: "J", x: 74, y: 150 },
        { label: "K", x: 19, y: 78 },
        { label: "L", x: 12, y: 180 },
        { label: "M", x: 81, y: -18 },
        { label: "N", x: 350, y: 6 },
        { label: "O", x: 65, y: 78 },
        { label: "P", x: -50, y: 50 },
    ];

    return (
        <>
            {/*<div>*/}
            {/*    <h1>D3.js in React (Vite)</h1>*/}
            {/*    <BarChart data={data} />*/}
            {/*</div>*/}

            <h1>Your current Location</h1>
            <LocationFetcher/>
            <div className="card">
                <h2>Map with Nodes and Connections</h2>
                <Map coordinates={coordinates} />
            </div>
            <p className="read-the-docs">
                Click on the Vite and React logos to learn more
            </p>
        </>
    );
}

export default App;
