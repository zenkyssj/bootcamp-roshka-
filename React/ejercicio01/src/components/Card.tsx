import '../styles/Card.css';

type Link = {
    linkTitle: string;
}

interface CardProps{
    card: {
        img: string;
        title: string;
        description: string;
        links: Link[];
    }
}

export const Card: React.FC<CardProps> = ( {card }) => {
    return(
        <div className="card">
            <div className="card-image">
                <img src={card.img} alt={card.title} />
            </div>
            <div className="card-content">
                <h2 className="card-title">{card.title}</h2>
                <p className="card-description">{card.description}</p>
                <div className="card-links">
                    {card.links.map((link, index) => (
                        <button key={index} className="card-link">
                            {link.linkTitle} {'>>'} 
                        </button>                     
                    ))}
                </div>
            </div>
        </div>
    );
};