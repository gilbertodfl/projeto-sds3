import NavBar from "components/NavBar";
import Footer from "components/Footer";
import DataTable from "components/DataTable";
import BarChart from "components/BarChart";
import DonutChart from "components/DonutChart";

function App() {

  return (
    <>
      <div className="container">
        <NavBar />
        <h1 className="text-primary py-3"> Dashboard de Vendas - Semana Spring React 4.0</h1>
        <div className="row px-3">
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Taxa de sucessos (%)</h5>
            <BarChart />
          </div>
          <div className="col-sm-6">
            <h5 className="text-center text-secondary">Total de Vendas(%)</h5>
            <DonutChart />
          </div>

        </div>
        <div className="py-3 ">
          <h2 className="text-primary">Todas vendas</h2>
        </div>
        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
